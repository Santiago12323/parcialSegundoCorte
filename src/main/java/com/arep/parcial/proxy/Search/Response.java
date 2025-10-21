package com.arep.parcial.proxy.Search;

public class Response {
    private String operation;
    private String inputlist;
    private int value;
    private int output;

    public Response(String operation, String inputlist, int value, int output) {
        this.operation = operation;
        this.inputlist = inputlist;
        this.value = value;
        this.output = output;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getInputlist() {
        return inputlist;
    }

    public void setInputlist(String inputlist) {
        this.inputlist = inputlist;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
