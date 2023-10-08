import java.time.LocalDate;
import java.time.LocalTime;

abstract class Ballot {

    private Person owner;
    private Candidate candidate;

    public Ballot(Person owner, Candidate candidate) {

        this.owner = owner;
        this.candidate = candidate;

    }

    public Person getOwner() {return this.owner;}
    public Candidate getCandidate() {return this.candidate;}
    public abstract String getType();

}

class ElectionDayVote extends Ballot {

    private String poll_location;
    private LocalTime time_of_count;

    public ElectionDayVote(Person owner, Candidate candidate, String poll_location) {

        super(owner, candidate);
        this.poll_location = poll_location;

    }

    public void Count() {time_of_count = LocalTime.now();}
    public String getLocation() {return this.poll_location;}
    public LocalTime getTimeOfCount() {return this.time_of_count;}
    public String getType() {return "Voted on Election Day";}

}

class AdvancePollVote extends Ballot {

    private String poll_location;
    private LocalDate day_of_vote;
    private LocalTime time_of_count;

    public AdvancePollVote(Person owner, Candidate candidate, String poll_location, LocalDate day_of_vote) {

        super(owner, candidate);
        this.poll_location = poll_location;
        this.day_of_vote = day_of_vote;

    }

    public void Count() {time_of_count = LocalTime.now();}
    public String getLocation() {return this.poll_location;}
    public LocalDate getDayOfVote() {return this.day_of_vote;}
    public LocalTime getTimeOfCount() {return this.time_of_count;}
    public String getType() {return "Voted by advance poll";}

}
