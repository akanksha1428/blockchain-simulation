# Blockchain Simulation

## Overview

This project simulates a basic blockchain using Java. It mimics core blockchain features such as linked blocks, hashing, and the detection of tampered data. The simulation creates a chain of blocks where each block contains a list of transactions, the hash of the previous block, and the current block's hash.

## Features

- **Block Structure**: Each block contains:
  - Block number (or index)
  - Timestamp of block creation
  - A list of transactions (dummy data)
  - Previous block's hash
  - Current block's hash

- **Hashing**: The project uses the SHA-256 hashing algorithm to generate the block's hash based on its data and the previous block's hash.

- **Blockchain Management**: A `Blockchain` class is implemented to manage the chain of blocks. It includes methods to:
  - Add new blocks
  - Validate the chain's integrity by checking if the hashes link correctly.

- **Tampering Detection**: The blockchain is capable of detecting tampered data by verifying the integrity of the chain's hashes.

- **Optional**: Basic proof-of-work implementation is included to make the block creation computationally intensive by requiring a hash value to meet specific conditions.

## Requirements

- JDK 17 or later (for Java programming)
- Java compiler and runtime environment

## Setup and Execution

1. **Clone the repository**:

   To get started, clone the project to your local machine using the following command:

  git clone https://github.com/akanksha1428/blockchain-simulation.git
  
2. **Navigate to the project directory**:

Change to the project directory:

cd blockchain-simulation

3. **Compile the project**:

To compile the Java files, use the following command:

javac -d bin src/*.java

4. **Run the simulation**:

To run the simulation, use the following command:

java BlockchainSimulation

5. **Output**:

The simulation will display details about the blockchain, including:

Block information (timestamp, transactions, previous and current hashes)
Whether the blockchain is valid or if tampering is detected.
