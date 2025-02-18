import axios from "axios"
import { createURL } from "../utils"


export async function getAvailableSeats(trainNumber, date) {
  try {
    const url = createURL("bookings/seats")
    const body = {
      trainNumber, date
    }

    const response = await axios.post(url, body)

    return response
  } 
  catch (ex) {
    if(ex.response) {
      return {
        status: ex.response.status,
        message: ex.response.data.message
      }
    }
    else if(ex.request) {
      return {
        status: 0,
        message: "No response from server"
      }
    }
    else {
      return {
        status: 0,
        message: `Request setup error: ${ex.message}`
      }
    }
  }
}