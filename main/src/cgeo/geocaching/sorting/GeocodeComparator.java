package cgeo.geocaching.sorting;

import cgeo.geocaching.Geocache;

import org.apache.commons.lang3.StringUtils;

/**
 * sorts caches by GC code, therefore effectively sorting by cache age
 *
 */
public class GeocodeComparator extends AbstractCacheComparator {

    @Override
    protected boolean canCompare(Geocache cache1, Geocache cache2) {
        return StringUtils.isNotBlank(cache1.getGeocode())
                && StringUtils.isNotBlank(cache2.getGeocode());
    }

    @Override
    protected int compareCaches(final Geocache cache1, final Geocache cache2) {
        final int lengthDiff = cache1.getGeocode().length() - cache2.getGeocode().length();
        return lengthDiff != 0 ? lengthDiff : cache1.getGeocode().compareToIgnoreCase(cache2.getGeocode());
    }
}
