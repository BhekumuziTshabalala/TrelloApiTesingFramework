package org.bhekumuzi.Resources;

public enum APIResources {
    CreateBoardAPI("/boards");

    private String resource;


    APIResources(String resource){
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

}
