## Run using docker

- Required Docker (tested with 29.3.0)

- Navigate to payroll/

- Create a docker image:  `docker build -t payroll-java25 .
`
- Run the image: `docker run --rm payroll-java25`

## Run using IntellijIDEA

- Load the payroll/ dir in Intellij

- Go to Settings > Project Structure > Project Settings > Project

- Set the SDK to openjdk-24 (Oracle OpenJDK 24.0.1)

- Apply the changes
