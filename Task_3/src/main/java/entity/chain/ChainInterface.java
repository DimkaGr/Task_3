package entity.chain;

public interface ChainInterface {
    public ChainInterface linkedWith(ChainInterface element);
    public String nextParse();
    public abstract String parse();
}
