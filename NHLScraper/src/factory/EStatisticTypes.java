package factory;

public enum EStatisticTypes {
    BASIC_SKATER("basic"),
    ADVANCED_SKATER("advanced"),
    GOALIE("goalie");
    
    EStatisticTypes(String factoryType) {
        this.factoryType = factoryType;
    }

    private final String factoryType;
    
    public String getType() {
        return factoryType;
    }
}
