import java.io.PrintWriter;
import java.util.Locale;

import pack.*;

public class Lab02_XXYYYY {
    private static final int START_N = 100_000;
    private static final int END_N = 1_000_000;
    private static final int STEP = 100_000;
    private static final int WARMUP_ROUNDS = 0;
    private static final int MEASURE_ROUNDS = 3;

    public static void main(String[] args) {
        L2_IsPrimeInterface[] algorithms = {
            new IsPrime0(),
            new IsPrime1(),
            new IsPrime2()
        };
        String[] labels = {"isPrime0", "isPrime1", "isPrime2"};

        testIsPrime012(algorithms, labels);

        BenchmarkResult[] results = new BenchmarkResult[algorithms.length];
        for (int i = 0; i < algorithms.length; i++) {
            results[i] = benchmark(labels[i], algorithms[i]);
        }

        printTask2Table(results);
        printTask3Analysis(results[0]);
        printRatioComparison(results[0], results[1], "isPrime0 vs isPrime1");
        printRatioComparison(results[1], results[2], "isPrime1 vs isPrime2");
        writeRuntimeCsv(results, "runtime_all_algorithms.csv");
        writePairCsv(results[0], results[1], "isPrime0_vs_isPrime1.csv");
        writePairCsv(results[1], results[2], "isPrime1_vs_isPrime2.csv");
    }

    private static void testIsPrime012(L2_IsPrimeInterface[] algorithms, String[] labels) {
        int N = 100;
        int expected = 25;
        System.out.println("Correctness check: prime count below " + N);
        for (int i = 0; i < algorithms.length; i++) {
            int count = countPrimes(algorithms[i], N);
            String status = (count == expected) ? "OK" : "CHECK";
            System.out.printf("%-8s Pi(%d) = %d  [%s]%n", labels[i], N, count, status);
        }
    }

    private static BenchmarkResult benchmark(String label, L2_IsPrimeInterface algorithm) {
        int dataPoints = (END_N - START_N) / STEP + 1;
        int[] sizes = new int[dataPoints];
        int[] counts = new int[dataPoints];
        long[] timesMs = new long[dataPoints];

        System.out.println();
        System.out.println("Benchmark: " + label);
        System.out.println("N\tprimeCount\ttimeMs");

        int idx = 0;
        for (int n = START_N; n <= END_N; n += STEP) {
            for (int w = 0; w < WARMUP_ROUNDS; w++) {
                countPrimes(algorithm, n);
            }

            long[] measured = new long[MEASURE_ROUNDS];
            int count = 0;
            for (int r = 0; r < MEASURE_ROUNDS; r++) {
                long start = System.currentTimeMillis();
                count = countPrimes(algorithm, n);
                measured[r] = System.currentTimeMillis() - start;
            }
            long elapsed = median(measured);

            sizes[idx] = n;
            counts[idx] = count;
            timesMs[idx] = elapsed;

            System.out.printf("%d\t%d\t%d%n", n, count, elapsed);
            idx++;
        }

        return new BenchmarkResult(label, sizes, counts, timesMs);
    }

    private static int countPrimes(L2_IsPrimeInterface algorithm, int upperExclusive) {
        int count = 0;
        for (int n = 1; n < upperExclusive; n++) {
            if (algorithm.isPrime(n)) {
                count++;
            }
        }
        return count;
    }

    private static void printTask2Table(BenchmarkResult[] results) {
        BenchmarkResult isPrime0 = results[0];
        BenchmarkResult isPrime1 = results[1];
        BenchmarkResult isPrime2 = results[2];

        System.out.println();
        System.out.println("Task 2 - Running-time table");
        System.out.println("n\tnumPrime(n)\tisPrime0(ms)\tisPrime1(ms)\tisPrime2(ms)");
        for (int i = 0; i < isPrime0.sizes.length; i++) {
            System.out.printf(
                "%d\t%d\t%d\t%d\t%d%n",
                isPrime0.sizes[i],
                isPrime0.counts[i],
                isPrime0.timesMs[i],
                isPrime1.timesMs[i],
                isPrime2.timesMs[i]
            );
        }
    }

    private static void printTask3Analysis(BenchmarkResult result) {
        System.out.println();
        System.out.println("Task 3 - Running-Time Analysis for " + result.label);
        System.out.println("n\tDataSizeRatio\tTime(ms)\tTimeRatio(vs100k)\tIncreasedFactor");

        double baseTime = result.timesMs[0];
        double prevTimeRatio = 0.0;
        for (int i = 0; i < result.sizes.length; i++) {
            int n = result.sizes[i];
            int dataSizeRatio = n / START_N;
            double timeRatio = (baseTime == 0.0) ? 0.0 : (result.timesMs[i] / baseTime);
            double increasedFactor = (i == 0 || prevTimeRatio == 0.0) ? 0.0 : (timeRatio / prevTimeRatio);

            System.out.printf(
                Locale.US,
                "%d\t%dn\t%d\t%.4f\t%s%n",
                n,
                dataSizeRatio,
                result.timesMs[i],
                timeRatio,
                (i == 0 ? "-" : String.format(Locale.US, "%.4f", increasedFactor))
            );
            prevTimeRatio = timeRatio;
        }
    }

    private static void printRatioComparison(BenchmarkResult a, BenchmarkResult b, String title) {
        System.out.println();
        System.out.println("Ratio comparison: " + title);
        System.out.println("N\t" + a.label + "/" + b.label);
        for (int i = 0; i < a.sizes.length; i++) {
            double ratio = safeDivide(a.timesMs[i], b.timesMs[i]);
            System.out.printf(Locale.US, "%,d\t%.4f%n", a.sizes[i], ratio);
        }
        System.out.println("Use these ratios to compare behavior across different machines.");
    }

    private static void writePairCsv(BenchmarkResult a, BenchmarkResult b, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.printf("N,%s_ms,%s_ms,%s_over_%s_ratio%n", a.label, b.label, a.label, b.label);
            for (int i = 0; i < a.sizes.length; i++) {
                double ratio = safeDivide(a.timesMs[i], b.timesMs[i]);
                pw.printf(Locale.US, "%d,%d,%d,%.6f%n", a.sizes[i], a.timesMs[i], b.timesMs[i], ratio);
            }
            System.out.println("Saved CSV: " + fileName);
        } catch (Exception ex) {
            System.out.println("Cannot write " + fileName + ": " + ex.getMessage());
        }
    }

    private static void writeRuntimeCsv(BenchmarkResult[] results, String fileName) {
        BenchmarkResult isPrime0 = results[0];
        BenchmarkResult isPrime1 = results[1];
        BenchmarkResult isPrime2 = results[2];
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println("N,numPrime,isPrime0_ms,isPrime1_ms,isPrime2_ms");
            for (int i = 0; i < isPrime0.sizes.length; i++) {
                pw.printf(
                    "%d,%d,%d,%d,%d%n",
                    isPrime0.sizes[i],
                    isPrime0.counts[i],
                    isPrime0.timesMs[i],
                    isPrime1.timesMs[i],
                    isPrime2.timesMs[i]
                );
            }
            System.out.println("Saved CSV: " + fileName);
        } catch (Exception ex) {
            System.out.println("Cannot write " + fileName + ": " + ex.getMessage());
        }
    }

    private static double safeDivide(long numerator, long denominator) {
        if (denominator == 0L) {
            return 0.0;
        }
        return (double) numerator / denominator;
    }

    private static long median(long[] values) {
        java.util.Arrays.sort(values);
        int mid = values.length / 2;
        if (values.length % 2 == 1) {
            return values[mid];
        }
        return (values[mid - 1] + values[mid]) / 2;
    }

    private static class BenchmarkResult {
        private final String label;
        private final int[] sizes;
        private final int[] counts;
        private final long[] timesMs;

        private BenchmarkResult(String label, int[] sizes, int[] counts, long[] timesMs) {
            this.label = label;
            this.sizes = sizes;
            this.counts = counts;
            this.timesMs = timesMs;
        }
    }
}
