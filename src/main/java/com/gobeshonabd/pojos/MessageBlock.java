package com.gobeshonabd.pojos;

public class MessageBlock
    {

    private int message_block_id;
    private int user_who_will_block;
    private int user_who_will_be_blocked;
    private String date_of_block;

    public MessageBlock()
        {
        }

    public MessageBlock(int message_block_id, int user_who_will_block, int user_who_will_be_blocked, String date_of_block)
        {
            this.message_block_id = message_block_id;
            this.user_who_will_block = user_who_will_block;
            this.user_who_will_be_blocked = user_who_will_be_blocked;
            this.date_of_block = date_of_block;
        }
    
    public int getMessage_block_id()
        {
        return message_block_id;
        }

    public void setMessage_block_id(int message_block_id)
        {
        this.message_block_id = message_block_id;
        }

    public int getUser_who_will_block()
        {
        return user_who_will_block;
        }

    public void setUser_who_will_block(int user_who_will_block)
        {
        this.user_who_will_block = user_who_will_block;
        }

    public int getUser_who_will_be_blocked()
        {
        return user_who_will_be_blocked;
        }

    public void setUser_who_will_be_blocked(int user_who_will_be_blocked)
        {
        this.user_who_will_be_blocked = user_who_will_be_blocked;
        }

    public String getDate_of_block()
        {
        return date_of_block;
        }

    public void setDate_of_block(String date_of_block)
        {
        this.date_of_block = date_of_block;
        }
        
    }
