package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

/**
 * A demonstration class for testing different types of rhymer implementations.
 * This class provides a way to test various rhymer behaviors including standard,
 * false, FIFO, and Hanoi rhymers.
 * 
 * The class contains:
 * - A main method that initializes a default rhymer factory and runs tests
 * - A private test method that demonstrates the functionality of different rhymers
 * 
 * The test includes:
 * - Sequential number input for standard, false, and FIFO rhymers (1-14)
 * - Random number input (0-19) for Hanoi rhymer
 * - Output demonstration of all rhymers
 * - Report of rejected numbers from Hanoi rhymer
 * 
 * @see RhymersFactory
 * @see DefaultRhymersFactory
 * @see DefaultCountingOutRhymer
 * @see HanoiRhymer
 */
class RhymersDemo {

    /**
     * The main entry point of the Rhymers demonstration application.
     * Creates a default factory and runs rhymer tests using the factory.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }
    // Comment on test: Looks good to me :3
    /**
     * Tests different types of rhymers from the provided factory.
     * The method creates four types of rhymers: standard, false, FIFO, and Hanoi.
     * It then fills the first three rhymers with numbers 1 to 14,
     * and the Hanoi rhymer with random numbers between 0 and 19.
     * After filling, it prints all numbers from each rhymer (in the order they come out)
     * and finally reports the total number of rejected values in the Hanoi rhymer.
     *
     * @param factory The factory used to create different types of rhymers
     */
    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};
        
        for (int i = 1; i < 15; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++)
            rhymers[3].countIn(rn.nextInt(20));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
        
    }
    
}