package entity.chain;

public abstract class ChainClass implements ChainInterface{
    ChainInterface next;

    @Override
    public ChainInterface linkedWith(ChainInterface next) {
        this.next=next;
        return next;
    }
    @Override
    public String nextParse(){
        if(next!=null){
            return next.parse();
        }else return "";
    }

}
