# Schema Design for Smart Clinic

## Doctor Table
- id (Primary Key)
- name
- specialization

## Patient Table
- id (Primary Key)
- name
- age
- gender

## Appointment Table
- id (Primary Key)
- doctor_id (FK)
- patient_id (FK)
- appointment_date
- notes
