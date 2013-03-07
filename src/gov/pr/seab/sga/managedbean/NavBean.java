package gov.pr.seab.sga.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class NavBean {

    private String activePage = "";


    public String getActivePage() {
        return activePage;
    }


    public void setActivePage(String activePage) {
        this.activePage = activePage;
    }


    public void next(ActionEvent e) {
        this.setActivePage("someotherpage.xhtml");
    }


    public void back(ActionEvent e) {
        this.setActivePage("somepage.xhtml");
    }
}