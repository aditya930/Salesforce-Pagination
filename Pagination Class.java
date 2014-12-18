public class listOfContacts {
    

    public ApexPages.StandardSetController setCon {
       
        get {
             if(setCon==NULL){
                setCon = new ApexPages.StandardSetController(Database.getQueryLocator([SELECT ID,
                                                                                        AccountId,
                                                                                        FirstName,
                                                                                        LastName,
                                                                                        Title,
                                                                                        Email,
                                                                                        Phone,
                                                                                        Birthdate
                                                                                        FROM Contact]));
       // setCon.setPageSize(5);
        }

            
            return setCon;
        }

        set;
    }

    public List <Contact> getContacts() {
        return (List<Contact>) setCon.getRecords();
    }
    
}