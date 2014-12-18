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
        setCon.setPageSize(5);
        }

            
            return setCon;
        }

        set;
    }

    public List <Contact> getContacts() {
        return (List<Contact>) setCon.getRecords();
    }

    public Boolean hasNext{
       get {
        return setCon.getHasNext();
       }

       set; 
    }

    public Boolean hasPrevious{
        get{
            return setCon.getHasPrevious();
        }

        set;
    }

    public void first() {
        setCon.first();
    }

    public void last() {
        setCon.last();
    }

    public void next() {
        setCon.next();
    }

    public void previous() {
        setCon.previous();
    }

    public Integer pageNumber {
        get{
            return setCon.getPageNumber();
        }
        set;
    }
    
    public Integer getTotalPages() {
        Decimal totalSize = setCon.getResultSize();
        Decimal pageSize = setCon.getPageSize();
         Decimal pages = totalSize/pageSize;

         return (Integer)pages.round(System.RoundingMode.CEILING);
    }
}