# gft-training
# Restaurant Booking Application

This application is built with version 1.0.5 of MuseServer.IO and requires Java 21.

## Testing Endpoints

You can test the endpoints using the following methods:

### POST Endpoint

- **URL:** `http://localhost:{port}/booking`
- **Method:** POST
- **Body:**
  ```json
  {
    "customerName": "John Doe",
    "tableSize": 4,
    "date": "2024-03-15",
    "time": "18:00"
  }
  ```

### GET Endpoint

- **URL:** `http://localhost:{port}/bookings?date=2024-03-15`
- **Method:** GET

Replace `{port}` with the appropriate port number where your server is running.

---
.