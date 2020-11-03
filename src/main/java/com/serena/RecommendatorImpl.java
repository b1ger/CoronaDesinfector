package com.serena;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("whiskey")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created.");;
    }

    @Override
    public void recommend() {
        System.out.println("To protect from Covid-2019, drink " + alcohol);
    }
}
