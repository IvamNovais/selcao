import api from "./Api.js"

async function getToken(credenciais){
        const token = await api.post("/oauth/token",{
        auth: {
            Username: 'Bam',
            Password: '123'
         },
         grant_type: "password",
         credenciais

    })
    console.log(token)
    return token
}
export default getToken