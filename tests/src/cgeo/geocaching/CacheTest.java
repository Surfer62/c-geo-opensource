package cgeo.geocaching;

import cgeo.geocaching.enumerations.CacheType;

import android.test.AndroidTestCase;

import java.util.Date;

public class CacheTest extends AndroidTestCase {

    final static private class MockedEventCache extends Geocache {
        public MockedEventCache(final Date date) {
            setHidden(date);
            setType(CacheType.EVENT);
        }
    }

    public static void testCanBeAddedToCalendar() {
        final Date today = new Date();
        final Geocache cacheToday = new MockedEventCache(today);
        assertTrue(cacheToday.canBeAddedToCalendar());

        final Date yesterday = new Date(today.getTime() - 86400 * 1000);
        final MockedEventCache cacheYesterday = new MockedEventCache(yesterday);
        assertFalse(cacheYesterday.canBeAddedToCalendar());
    }

    public static void testEquality() {
        final Geocache one = new Geocache();
        final Geocache two = new Geocache();

        // identity
        assertTrue(one.equals(one));

        // different objects without geocode shall not be equal
        assertFalse(one.equals(two));

        one.setGeocode("geocode");
        two.setGeocode("geocode");

        // different objects with same geocode shall be equal
        assertTrue(one.equals(two));
    }

    public static void testGeocodeUppercase() {
        Geocache cache = new Geocache();
        cache.setGeocode("gc1234");
        assertEquals("GC1234", cache.getGeocode());
    }
}
