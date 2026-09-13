from pydantic import BaseModel
from typing import Literal


class RouteRequest(BaseModel):
    origin_lat: float
    origin_lng: float
    destination_lat: float
    destination_lng: float
    mode: Literal["walking", "driving", "cycling"]


class RouteResponse(BaseModel):
    mode: str
    distance_meters: float
    duration_seconds: float
    polyline: list[list[float]]  # list of [lat, lng] points