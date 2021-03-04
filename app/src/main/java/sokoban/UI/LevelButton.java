package sokoban.UI;

import javafx.scene.image.Image;

public class LevelButton extends ImageButton{
    int Lvl;
    public LevelButton(Image selected, Image unselected,int Lvl) throws Exception {
        super(selected, unselected);
        this.Lvl=Lvl;
    }
    public void  set_Lvl(int a){
        Lvl = a;
    }
    public int get_Lvl(){
        return Lvl;
    }
}
