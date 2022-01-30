import java.util.ArrayList;
import java.util.List;

public class Sequence {
    private String sequence;
    private int length;
    private List<List<String>> subSequences;

    public Sequence(String sequence) {
     this.sequence = sequence;
     this.length = sequence.length();
    }

    public List<String> getAllPossibleSubsequences() {
        List<String> allPossibleSubseq = new ArrayList<>();
        for(int i=1; i<this.length; i++) {
            allPossibleSubseq.addAll(getSubsequencesOfLength(i));
        }
        return allPossibleSubseq;
    }

    public List<String> getSubsequencesOfLength(int subseqLength) throws IndexOutOfBoundsException{
        List<String> seqList = new ArrayList<>();
        //l - subseq start index
        for(int l = 0; l <= this.length - subseqLength; l ++) {
            seqList.add(this.sequence.substring(l, l+subseqLength));
        }
        return seqList;
    }
}
