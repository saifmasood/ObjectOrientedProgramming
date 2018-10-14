package com.oop.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Row> rows;
    private int maxRows;

    public Level(int numRows){
        maxRows = numRows;
        rows = new ArrayList<>();
    }

    public void addRow(Row row){
        if(rows.size() == maxRows){
            System.out.println("No more rows can be added");
        }else{
            rows.add(row);
        }
    }

    public List<Row> getRows(){
        return rows;
    }
}
