package com.epam.rd.contactbook;

public class Contact {

    private String contactName;

    private final Email[] emails = new Email[3];
    private final Social[] links = new Social[5];
    private int emailsCounter = 0;
    private int socialCount = 0;
    private ContactInfo numberInfo;

    public Contact(String contactName) {
        //Implement this method
        this.contactName = contactName;
    }

    public void rename(String newName) {
        //Implement this method
        if(newName != "" && newName!=null){
            contactName = newName;
        }
    }
    private class NameContactInfo  implements ContactInfo{
        @Override
        public String getTitle() {
            return "Name";
        }
        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo{

        public String email;

        @Override
        public String getTitle() {
            return "Email";
        }
        @Override
        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo{
        private String id;
        String header;
        @Override
        public String getTitle() {
            return header;
        }
        @Override
        public String getValue() {
            return id;
        }
    }

    public Email addEmail(String localPart, String domain) {
        //Implement this method
        if (emailsCounter < 3) {
            emails[emailsCounter] = new Email();
            emails[emailsCounter].email = localPart + "@" + domain;
            return emails[emailsCounter++];
        } else return null;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        //Implement this method
        if (emailsCounter < 3) {
            emails[emailsCounter] = new Email() {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
                @Override
                public String getValue() {
                    return firstname + "_" +  lastname + "@epam.com";
                }
            };
            return emails[emailsCounter++];
        } else return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        //Implement this method
        if (numberInfo == null) {
            numberInfo = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }
                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            return numberInfo;
        } else return null;
    }

    public Social addTwitter(String twitterId) {
        //Implement this method
        if(socialCount<5){
            links[socialCount]= new Social(){
                @Override
                public String getTitle() {
                    return "Twitter";
                }
                @Override
                public String getValue() {
                    return twitterId;
                }
            };
            return links[socialCount++];
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        //Implement this method
        if(socialCount<5){
            links[socialCount]=new Social(){
                @Override
                public String getTitle() {
                    return "Instagram";
                }
                @Override
                public String getValue() {
                    return instagramId;
                }
            };
            return links[socialCount++];
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        //Implement this method
        if (socialCount < 5) {
            links[socialCount] = new Social() {
                @Override
                public String getTitle() {
                    return title;
                }
                @Override
                public String getValue() {
                    return id;
                }
            };
            return links[socialCount++];
        } else return null;
    }

    public ContactInfo[] getInfo() {
        //Implement this method
        ContactInfo[] info =
                new ContactInfo[1 + emailsCounter
                        + socialCount
                        + (numberInfo == null ? 0 : 1)];
        int index = -0;
        ContactInfo nameContactInfo = new NameContactInfo() {
            @Override
            public String getTitle() {
                return "Name";
            }
            @Override
            public String getValue() {
                return contactName;
            }
        };
        info[index] = nameContactInfo;
        index++;
        if (this.numberInfo != null) {
            info[index] = numberInfo;
            index++;
        }
        for (ContactInfo el : emails) {
            if (el != null) {
                info[index] = el;
                index++;
            }
        }
        for (ContactInfo el : links) {
            if (el != null) {
                info[index] = el;
                index++;
            }
        }
        return info;
    }


}