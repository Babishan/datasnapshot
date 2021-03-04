//variable "access_key" {
//  default     = AWS_ACCESS_KEY_ID
//  type        = string
//  description = "Access Key"
//}
//variable "secret_key" {
//  default     = AWS_SECRET_ACCESS_KEY
//  type        = string
//  description = "Secret key"
//}

variable "region" {
  default     = "eu-central-1"
  type        = string
  description = "Region of the VPC"
}

variable "ami" {
  default     = "ami-0932440befd74cdba"
  type        = string
  description = "AMI for the ec2"
}

variable "instance_type" {
  default     = "t2.micro"
  type        = string
  description = "Keep it free"
}

variable "subnets" {
  default     = ["subnet-036fcd05448a9b0c3","subnet-0cf84b6c2e05455a7"]
  type        = list
  description = "List of available subnets"
}

variable "security_group" {
  default     = "sg-03422c06229cca747"
  type        = string
  description = "Allowed security group"
}

//
//variable "cidr_block" {
//  default     = "10.0.0.0/16"
//  type        = string
//  description = "CIDR block for the VPC"
//}
//
//variable "availability_zones" {
//  default     = ["eu-central-1a", "eu-central-1b"]
//  type        = list
//  description = "List of availability zones"
//}
//
//variable "public_subnet_cidr_blocks" {
//  default     = ["10.0.0.0/24", "10.0.2.0/24"]
//  type        = list
//  description = "List of public subnet CIDR blocks"
//}
//
//variable "private_subnet_cidr_blocks" {
//  default     = ["10.0.1.0/24", "10.0.3.0/24"]
//  type        = list
//  description = "List of private subnet CIDR blocks"
//}

