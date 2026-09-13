from fastapi import FastAPI
from app.database.connection import Base, engine
from app.models import user, journey
from app.api.users import router as users_router

Base.metadata.create_all(bind=engine)

app = FastAPI(title="SmartTransit Backend")
app.include_router(users_router)


@app.get("/health")
def health_check():
    return {"status": "OK"}


@app.get("/")
def root():
    return {"message": "SmartTransit backend is running"}