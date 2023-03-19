package factory;

public enum EStatisticTypes {
    BASIC_SKATER("basic"),
    ADVANCED_SKATER("advanced"),
    GOALIE("goalie"),
    STANDINGS("standings");
    
    EStatisticTypes(String factoryType) {
        this.factoryType = factoryType;
    }

    private final String factoryType;
    
    public String getType() {
        return factoryType;
    }
}
