package actor;

import core.GameStatus;
import core.LoadEntity;
import org.newdawn.slick.SlickException;

public class Portals {

    /**
     * Obsługa przejść pomiędzy mapami
     *
     * @param gs
     * @return 1 - wykryto obszar przejścia, 
     * @return 0 - nie wykryto przejścia przez portal
     * @throws SlickException
     */
    public boolean isEnter(GameStatus gs, int playerCenterX, int playerCenterY) throws SlickException {
        int iter = 0;
        for (int i = 0; i < gs.portalMapList.size(); i++) {
            
/*
W razie problemów z portalami odkomentować
*/

//            System.out.println("x=" + gs.x + " y=" + gs.y + ", xS=" + gs.portalMapList.get(i).xStart + " xE=" + gs.portalMapList.get(i).xEnd
//                    + " yS=" + gs.portalMapList.get(i).yStart + " yE=" + gs.portalMapList.get(i).yEnd + "\n");


            if (((gs.x >= gs.portalMapList.get(i).xStart) && (gs.x <= gs.portalMapList.get(i).xEnd))
                    && ((gs.y >= gs.portalMapList.get(i).yStart) && (gs.y <= gs.portalMapList.get(i).yEnd))) {
                gs.levelID = gs.portalMapList.get(i).levelID;
                gs.x = gs.portalMapList.get(i).xNew;
                gs.y = gs.portalMapList.get(i).yNew;
                return true;
            }
        }
        return false;
    }
}