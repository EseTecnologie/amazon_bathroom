public class Bathroom {
    Boolean inUse;
    int usesCount;
    final int bathroomID;
    Boolean toDelete;

    public Bathroom(int bathroomID) {
        this.bathroomID = bathroomID;
        inUse = false;
        usesCount = 0;
        toDelete = false;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public int getUsesCount() {
        return usesCount;
    }

    public boolean entryBathroom(){
        if(inUse) return false;
        inUse = true;
        usesCount++;
        return true;
    }
    public boolean canEnter(){
        if(inUse) return false;
        return true;
    }
    public void outBathroom(){
        inUse = false;
    }
}
