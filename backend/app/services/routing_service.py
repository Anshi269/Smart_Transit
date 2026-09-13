import httpx

# routing.openstreetmap.de hosts separate instances per mode, which correctly
# respect the mode (the shared router.project-osrm.org demo has a known bug
# where it silently ignores this and always returns driving routes).
OSRM_ENDPOINTS = {
    "walking": ("routed-foot", "foot"),
    "driving": ("routed-car", "driving"),
    "cycling": ("routed-bike", "bike"),
}


async def get_route(origin_lat: float, origin_lng: float,
                     destination_lat: float, destination_lng: float,
                     mode: str) -> dict:
    path_prefix, profile = OSRM_ENDPOINTS[mode]

    url = (
        f"https://routing.openstreetmap.de/{path_prefix}/route/v1/{profile}/"
        f"{origin_lng},{origin_lat};{destination_lng},{destination_lat}"
        f"?overview=full&geometries=geojson"
    )

    async with httpx.AsyncClient(timeout=10.0) as client:
        response = await client.get(url)
        response.raise_for_status()
        data = response.json()

    route = data["routes"][0]
    # OSRM returns coordinates as [lng, lat] — flip to [lat, lng] for our app
    polyline = [[point[1], point[0]] for point in route["geometry"]["coordinates"]]

    return {
        "mode": mode,
        "distance_meters": route["distance"],
        "duration_seconds": route["duration"],
        "polyline": polyline,
    }