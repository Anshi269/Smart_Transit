from sqlalchemy import Column, Integer, String, DateTime, ForeignKey, Float
from sqlalchemy.sql import func
from app.database.connection import Base


class Journey(Base):
    __tablename__ = "journeys"

    id = Column(Integer, primary_key=True, index=True)
    user_id = Column(Integer, ForeignKey("users.id"), nullable=False)
    origin_address = Column(String, nullable=False)
    destination_address = Column(String, nullable=False)
    route_type = Column(String)       # "fastest" / "cheapest" / "smart"
    status = Column(String, default="planned")  # planned, active, completed, cancelled
    created_at = Column(DateTime(timezone=True), server_default=func.now())


class JourneySegment(Base):
    __tablename__ = "journey_segments"

    id = Column(Integer, primary_key=True, index=True)
    journey_id = Column(Integer, ForeignKey("journeys.id"), nullable=False)
    sequence = Column(Integer, nullable=False)   # order within the journey: 1, 2, 3...
    mode = Column(String, nullable=False)        # "walk", "auto", "metro", "bus"
    duration_minutes = Column(Float)
    distance_meters = Column(Float)
    cost = Column(Float)


class JourneyEvent(Base):
    __tablename__ = "journey_events"

    id = Column(Integer, primary_key=True, index=True)
    journey_id = Column(Integer, ForeignKey("journeys.id"), nullable=False)
    event_type = Column(String)       # "started", "mode_changed", "delayed", "completed"
    timestamp = Column(DateTime(timezone=True), server_default=func.now())
    details = Column(String)