import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Election {

    ArrayList<Person> persons;
    ArrayList<Candidate> candidates;
    ArrayList<Ballot> ballots;

    static HashMap<String,Integer> candidatesIndexMap;

    public static void main (String[] args) {

        ArrayList<Person> persons = createPersons();
        ArrayList<Candidate> candidates = createCandidates();
        ArrayList<Ballot> ballots = createBallots(persons, candidates);

        int[] votes = new int[candidates.size()];

        for(Ballot ballot: ballots) {

            votes[candidatesIndexMap.get(ballot.getCandidate().getName())]++;

        }

        for(int i=0; i < votes.length; i++) {
            System.out.print(candidates.get(i).getName()+" : "+votes[i]+"\n");
        }

        System.out.print("\n");

        int gagnantIndex = -1,
                max = -1;

        for(int i=0; i< votes.length; i++) {
            if(max<votes[i]) {
                gagnantIndex = i;
                max = votes[i];
            }
        }

        System.out.print("Le gagnant de l'élection est "+candidates.get(gagnantIndex).getName()+".\n");

    }

    public static ArrayList<Person> createPersons() {

        ArrayList<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Laura Houde", "86 rue Loc",
                "(514)576-8141", LocalDate.of(1981,1,1)));
        persons.add(new Person("Claude Gagnant", "87 rue Loc",
                "(514)576-8142", LocalDate.of(1982,2,2)));
        persons.add(new Person("Samuel Rodrigue", "88 rue Loc",
                "(514)576-8143", LocalDate.of(1983,3,3)));
        persons.add(new Person("Jane Fortin", "89 rue Loc",
                "(514)576-8144", LocalDate.of(1984,4,4)));
        persons.add(new Person("Louis Rossignol", "90 rue Loc",
                "(514)576-8145", LocalDate.of(1985,5,5)));

        return persons;

    }

    public static ArrayList<Candidate> createCandidates() {

        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        candidatesIndexMap = new HashMap<>();

        candidates.add(new Candidate("Luc Poivier", "Partie Rouge"));
        candidatesIndexMap.put("Luc Poivier",0);

        candidates.add(new Candidate("George Abe", "Partie Bleu"));
        candidatesIndexMap.put("George Abe",1);

        candidates.add(new Candidate("Jesse Johnson", "Partie Vert"));
        candidatesIndexMap.put("Jesse Johnson",2);

        candidates.add(new Candidate("Liam Armstrong", "Partie Jaune"));
        candidatesIndexMap.put("Liam Armstrong",3);

        return candidates;
    }

    public static ArrayList<Ballot> createBallots(ArrayList<Person> persons, ArrayList<Candidate> candidates) {

        ArrayList<Ballot> ballots = new ArrayList<Ballot>();

        ballots.add(new ElectionDayVote(persons.get(0),candidates.get(0), "Station Proulx"));
        ballots.add(new AdvancePollVote(persons.get(1),candidates.get(1), "Station Proulx", LocalDate.of(2021,9,25)));
        ballots.add(new MailVote(persons.get(2),candidates.get(2), "Station Proulx", LocalDate.of(2021,9,20)));
        ballots.add(new ElectionDayVote(persons.get(3),candidates.get(3), "Station Proulx"));
        ballots.add(new AdvancePollVote(persons.get(4),candidates.get(2), "Station Proulx", LocalDate.of(2021,9,24)));

        return ballots;
    }

}
