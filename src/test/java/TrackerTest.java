import models.Tracker;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/8/17.
 */
public class TrackerTest {

    @Test
    public void StoredCD_IsInstanceCreated_True() throws Exception {
        Tracker testTracker = new Tracker("Eagles");
        assertEquals(true, testTracker instanceof Tracker);
    }

    @Test
    public void TrackerInstantiatesWithContent_true() throws Exception {
        Tracker testTracker = new Tracker("Eagles");
        assertEquals("Eagles", testTracker.getAlbumName());
    }

    @After
    public void tearDown() {
        Tracker.clearAllAlbums(); //clear out allll the albums before each test.
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Tracker testTracker = new Tracker("Eagles");
        Tracker otherTestTracker = new Tracker("First Album");
        assertEquals(2, Tracker.getAll().size());
    }

    @Test
    public void AllPostsContainAllPosts_true() {
        Tracker testTracker = new Tracker("Eagles");
        Tracker otherTestTracker = new Tracker("First Album");
        assertTrue(Tracker.getAll().contains(testTracker));
        assertTrue(Tracker.getAll().contains(otherTestTracker));

    }

}