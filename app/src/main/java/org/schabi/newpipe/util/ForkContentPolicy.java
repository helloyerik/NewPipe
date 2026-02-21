package org.schabi.newpipe.util;

import androidx.annotation.Nullable;

import org.schabi.newpipe.extractor.ServiceList;

import java.util.Set;

public final class ForkContentPolicy {
    private static final int ALLOWED_SERVICE_ID = ServiceList.YouTube.getServiceId();

    private static final Set<String> REMOVED_KIOSK_IDS = Set.of(
            "Trending",
            "trending_gaming",
            "trending_music",
            "trending_movies_and_shows",
            "trending_podcasts_episodes",
            "live"
    );

    private ForkContentPolicy() {
    }

    public static int getAllowedServiceId() {
        return ALLOWED_SERVICE_ID;
    }

    public static boolean isAllowedService(final int serviceId) {
        return serviceId == ALLOWED_SERVICE_ID;
    }

    public static boolean isRemovedKiosk(@Nullable final String kioskId) {
        return kioskId != null && REMOVED_KIOSK_IDS.contains(kioskId);
    }

    public static boolean isAllowedKiosk(final int serviceId, @Nullable final String kioskId) {
        return isAllowedService(serviceId) && !isRemovedKiosk(kioskId);
    }
}
