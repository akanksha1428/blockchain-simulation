import java.util.Arrays;

public class BlockchainSimulation {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        System.out.println("Original Blockchain:");
        Block genesisBlock = new Block(0, System.currentTimeMillis(),
                Arrays.asList("Genesis Block"), "0");
        blockchain.addBlock(genesisBlock);
        genesisBlock.mineBlock(4); // Mining the Genesis block with difficulty 4

        Block block1 = new Block(1, System.currentTimeMillis(),
                Arrays.asList("Alice paid Bob 10 BTC", "Bob paid Charlie 5 BTC"), genesisBlock.getCurrentHash());
        blockchain.addBlock(block1);
        block1.mineBlock(4); // Mining block1 with difficulty 4

        Block block2 = new Block(2, System.currentTimeMillis(),
                Arrays.asList("Charlie paid Dave 2 BTC", "Alice paid Eve 1 BTC"), block1.getCurrentHash());
        blockchain.addBlock(block2);
        block2.mineBlock(4); // Mining block2 with difficulty 4

        // Print the current blockchain state
        blockchain.printBlockchain();

        // Validate the blockchain
        System.out.println("Is blockchain valid? " + blockchain.isChainValid());

        // Tampering example
        System.out.println("\nTampering with Block #1...");
        blockchain.tamperBlock(1, "Tampered Data");

        // Print tampered blockchain and revalidate
        blockchain.printBlockchain();
        System.out.println("Is blockchain valid after tampering? " + blockchain.isChainValid());
    }
}


