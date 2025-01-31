import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        this.chain = new ArrayList<>();
    }

    public void addBlock(Block block) {
        chain.add(block);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.getCurrentHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current block hash is invalid.");
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getCurrentHash())) {
                System.out.println("Previous block hash is invalid.");
                return false;
            }
        }
        return true;
    }

    public void tamperBlock(int blockIndex, String tamperedData) {
        if (blockIndex < 0 || blockIndex >= chain.size()) {
            System.out.println("Invalid block index for tampering.");
            return;
        }
        Block blockToTamper = chain.get(blockIndex);
        List<String> updatedTransactions = new ArrayList<>(blockToTamper.getTransactions());
        updatedTransactions.add(tamperedData);
        blockToTamper.setTransactions(updatedTransactions);
    }

    public void printBlockchain() {
        for (Block block : chain) {
            System.out.println("Block #" + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Transactions: " + block.getTransactions());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Current Hash: " + block.getCurrentHash());
            System.out.println("=====================================");
        }
    }
}



