from fastapi import APIRouter, HTTPException
import httpx

from app.schemas.route import RouteRequest, RouteResponse
from app.services.routing_service import get_route

router = APIRouter(prefix="/routes", tags=["routes"])


@router.post("/", response_model=RouteResponse)
async def compute_route(request: RouteRequest):
    try:
        result = await get_route(
            request.origin_lat, request.origin_lng,
            request.destination_lat, request.destination_lng,
            request.mode
        )
        return result
    except httpx.HTTPStatusError:
        raise HTTPException(status_code=502, detail="Routing service error")
    except (KeyError, IndexError):
        raise HTTPException(status_code=404, detail="No route found between these points")