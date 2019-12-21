package org.gobeshona.pojos;

import org.hibernate.validator.constraints.NotEmpty;

public class Follow
    {

    //    1
    private int follwerIndex;
//    2
    private int columnA;
//    3
    private int columnB;
//    4
    private String date = "Date";

    public int getFollwerIndex()
        {
        return follwerIndex;
        }

    public void setFollwerIndex(int follwerIndex)
        {
        this.follwerIndex = follwerIndex;
        }

    public int getColumnA()
        {
        return columnA;
        }

    public void setColumnA(int columnA)
        {
        this.columnA = columnA;
        }

    public int getColumnB()
        {
        return columnB;
        }

    public void setColumnB(int columnB)
        {
        this.columnB = columnB;
        }

    public String getDate()
        {
        return date;
        }

    public void setDate(String date)
        {
        this.date = date;
        }

    }
