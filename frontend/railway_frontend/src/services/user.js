import axios from 'axios'
import { createURL } from './../utils';

export async function userRegister(userDetails) {
  try {
    const url = createURL("users/register")
    const {name, userName, password, email, phoneNo} = userDetails
    const body = {
      name, userName, password, email, phoneNo
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

export async function userLogin(userName, password) {
  try {
    const url = createURL("users/login")

    const body = {
      userName, password
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

export async function getUserDetails() {
  try {
    const url = createURL("users")
    const id = sessionStorage.getItem("userId")

    const response = await axios.get(url, {
      headers: {
        id
      }
    })

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

export async function updateProfile(userDetails) {
  try {
    const url = createURL("users/update")
    const id = sessionStorage.getItem("userId")
    const {name, userName, email, password, phoneNo} = userDetails
    const body = {
      name, userName, email, password, phoneNo
    }

    const response = await axios.put(url, body, {
      headers: {
        id
      }
    })

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

export async function deleteProfile() {
  try {
    const url = createURL("users/delete")
    const id = sessionStorage.getItem("userId")

    const response = await axios.delete(url, {
      headers: {
        id
      }
    })

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