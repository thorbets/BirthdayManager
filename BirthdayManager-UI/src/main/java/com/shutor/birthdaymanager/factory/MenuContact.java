package com.shutor.birthdaymanager.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuContact {

    protected List<MenuAction> listMenuAction;

    protected MenuContact() {
        listMenuAction = new ArrayList<>();
    }

    public void setActionContactMenu(ActionContactMenu actionContactMenu) {
        for (MenuAction menuAction : listMenuAction) {
            menuAction.setActionContactMenu(actionContactMenu);
        }
    }

    public List<MenuAction> createMenu() {
        return listMenuAction;
    }

    public MenuAction getMenu(int position) {
        try {
            return listMenuAction.get(position);
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
    }

    public int getMenuCount() {
        return listMenuAction.size();
    }
}
