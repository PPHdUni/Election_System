import java.time.LocalDate;

abstract class Ballot {

    private Person owner;
    private Candidate candidate;

    public Person getOwner() {return this.owner;}
    public Candidate getCandidate() {return this.candidate;}

}

class ElectionDayVote extends Ballot {



}
