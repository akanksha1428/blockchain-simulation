import java.security.MessageDigest;
import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private List<String> transactions;
    private String previousHash;
    private String currentHash;
    private int nonce;

    public Block(int index, long timestamp, List<String> transactions, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.currentHash = calculateHash();
    }

    public String calculateHash() {
        String dataToHash = index + Long.toString(timestamp) + transactions.toString() + previousHash + nonce;
        return applySha256(dataToHash);
    }

    public void mineBlock(int difficulty) {
        String targetPrefix = new String(new char[difficulty]).replace('\0', '0');
        while (!currentHash.substring(0, difficulty).equals(targetPrefix)) {
            nonce++;
            currentHash = calculateHash();
        }
        System.out.println("Block mined! Hash: " + currentHash);
    }

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public void setTransactions(List<String> newTransactions) {
        this.transactions = newTransactions;
        this.currentHash = calculateHash();
    }
}


