/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Serikov S.
 */
public class Document {

    public String documentType;
    public String documentNumber;
    public String documentExpire;
    public String documentIssueOrganization;

    public Document(String documentType, String documentNumber,
            String documentExpire, String documentIssueOrganization) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.documentExpire = documentExpire;
        this.documentIssueOrganization = documentIssueOrganization;
    }

    public Document() {
        this.documentType = "";
        this.documentNumber = "";
        this.documentExpire = "";
        this.documentIssueOrganization = "";
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentExpire() {
        return documentExpire;
    }

    public void setDocumentExpire(String documentExpire) {
        this.documentExpire = documentExpire;
    }

    public String getDocumentIssueOrganization() {
        return documentIssueOrganization;
    }

    public void setDocumentIssueOrganization(String documentIssueOrganization) {
        this.documentIssueOrganization = documentIssueOrganization;
    }

}
