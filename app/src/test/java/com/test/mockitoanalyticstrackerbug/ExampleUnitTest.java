package com.test.mockitoanalyticstrackerbug;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ExampleUnitTest {

    @Test
    public void watchTrackerFailToBeMockedTest() {
        Tracker mockTracker = Mockito.mock(Tracker.class);
        assertNotNull(mockTracker);
    }

    @Test
    public void watchTrackerFailToBeSpiedTest() {
        GoogleAnalytics googleAnalytics = GoogleAnalytics.getInstance(RuntimeEnvironment.application);
        Tracker tracker = googleAnalytics.newTracker(R.xml.global_tracker);

        Tracker spyTracker = Mockito.spy(tracker);
        assertNotNull(spyTracker);

        verify(spyTracker, never()).set("&iud", "test-string");
    }
}