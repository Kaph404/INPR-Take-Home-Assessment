public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String group;
    private String country;
    private String email;

    public Student(String firstName, String lastName, int age, String group, String country, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.country = country;
        this.email = email;
    }

    public Student(String firstName, String lastName, int age, String group, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.country = country;
        email = generateEmail();
    }

    public Student(String studentData) {
        String[] data = studentData.split(",");
        this.firstName = data[0];
        this.lastName = data[1];
        this.age = Integer.parseInt(data[2]);
        this.group = data[3];
        this.country = data[4];
        this.email = data[5];
    }

    /**
     * Method that formats the last name to have the first letter in uppercase if the last name is one word
     * If the last name is two words with a hyphen e.g. el-Sabir, the first letter of the first won't be upper case
     * , all subsequent words will have the first letter uppercase and the remaining letters lower case
     * @return formated last name
     */
    public String formatLastName() {
        if (lastName.contains("-")){
            lastName = lastName.substring(0, lastName.indexOf("-")+1).toLowerCase() +
                    lastName.substring(lastName.indexOf("-")+1, lastName.indexOf("-")+2).toUpperCase() +
                    lastName.substring(lastName.indexOf("-")+2).toLowerCase();
        }else{
            lastName = lastName.substring(0,1).toUpperCase() +
                    lastName.substring(1).toLowerCase();
        }
        return lastName;
    }

    public String getStudentName() {
        return firstName + " " + formatLastName();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Method to pick the first letter in first name and last name (in lower case),
     * generate a 3 digit random number and then add "@sussex.ac.uk" in the end, then we get the 'fake' email
     * @return generated 'fake' email address
     */
    public String generateEmail() {
        return firstName.substring(0, 1).toLowerCase() + lastName.substring(0, 1).toLowerCase() +
                getRandomNumber(100, 999) + "@sussex.ac.uk";
    }
    @Override
    public String toString() {
        return firstName + "," +
                lastName + "," +
                age + "," +
                group + "," +
                country + "," +
                email;
    }
}
