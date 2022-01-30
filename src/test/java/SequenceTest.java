import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SequenceTest {

    @Test
    public void shouldReturnAllSubstringsOfGivenLengthFromSequence() {
        final int substringLength = 2;
        final List<String> expectedSequences = Arrays.asList("ab", "bc", "cd");
        final int expectedSubstringsNo = 3;
        Sequence sequence = new Sequence("abcd");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions
        .assertThat(sequence.getSubsequencesOfLength(substringLength))
                .isEqualTo(expectedSequences);
        softAssertions
        .assertThat(sequence.getSubsequencesOfLength(substringLength).size())
                .isEqualTo(expectedSubstringsNo);
        softAssertions.assertAll();
    }

    @Test
    public void shouldReturnAllSubsequencesFromSequence() {
        Sequence sequence = new Sequence("abcd");
        final List<String> expectedSequences = Arrays.asList("a","b","c","d","ab","bc","cd","abc","bcd","abcd");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions
                .assertThat(sequence.getAllPossibleSubsequences().size())
                .isEqualTo(expectedSequences.size());
        softAssertions
                .assertThat(sequence.getAllPossibleSubsequences())
                .containsSequence(expectedSequences);
    }

    @Test
    public void shouldReturnEmptyListOfSubseqencesWhenEmptySequence() {
        Sequence sequence = new Sequence("");
        assertThat(sequence.getSubsequencesOfLength(3).size())
                .isEqualTo(0);
        assertThat(sequence.getAllPossibleSubsequences().size())
                .isEqualTo(0);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeSubsequenceLength() {
        Sequence sequence = new Sequence("aaaaa");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    sequence.getSubsequencesOfLength(-1);
                })
                .withMessage("begin 0, end -1, length 5");
    }
}
