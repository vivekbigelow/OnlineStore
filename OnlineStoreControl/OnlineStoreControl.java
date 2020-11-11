package OnlineStoreControl;

import java.util.Scanner;
import OnlineStoreModel.OnlineStoreModel;
import OnlineStoreView.OnlineStoreView;
import store.Store;

public class OnlineStoreControl{
    OnlineStoreModel model;
    OnlineStoreView view;
    Scanner readObj;
    String input;
    
    public OnlineStoreControl(Store store){
        this.readObj = new Scanner(System.in);
        this.model = new OnlineStoreModel(store);
        this.view = new OnlineStoreView();
    }

    public void startOnlineStore(){
        this.view.introductionDialogue();
    }

    public void getInput(){
        this.input = this.readObj.nextLine();
    }

    public void applicationLoop(){
        
    }
}