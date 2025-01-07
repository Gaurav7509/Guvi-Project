package example.model;

import java.sql.Timestamp;

/**
 * Represents a message between users.
 */
public class Message {
    private int id;
    private int senderId;
    private int receiverId;
    private String messageText;
    private Timestamp createdAt;

    /**
     * Constructor for Message.
     *
     * @param id         Unique identifier for the message.
     * @param senderId   Identifier for the user sending the message.
     * @param receiverId Identifier for the user receiving the message.
     * @param messageText Text content of the message.
     */
    public Message(int id, int senderId, int receiverId, String messageText) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageText = messageText;
    }

    /**
     * Constructor for Message.
     *
     * @param senderId   Identifier for the user sending the message.
     * @param receiverId Identifier for the user receiving the message.
     * @param messageText Text content of the message.
     */
    public Message(int senderId, int receiverId, String messageText) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageText = messageText;
    }

    /**
     * Gets the unique identifier for the message.
     *
     * @return Unique identifier for the message.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the message.
     *
     * @param id Unique identifier for the message.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the identifier for the user sending the message.
     *
     * @return Identifier for the user sending the message.
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * Sets the identifier for the user sending the message.
     *
     * @param senderId Identifier for the user sending the message.
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    /**
     * Gets the identifier for the user receiving the message.
     *
     * @return Identifier for the user receiving the message.
     */
    public int getReceiverId() {
        return receiverId;
    }

    /**
     * Sets the identifier for the user receiving the message.
     *
     * @param receiverId Identifier for the user receiving the message.
     */
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * Gets the text content of the message.
     *
     * @return Text content of the message.
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Sets the text content of the message.
     *
     * @param messageText Text content of the message.
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * Gets the date and time the message was created.
     *
     * @return Date and time the message was created.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the date and time the message was created.
     *
     * @param createdAt Date and time the message was created.
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}