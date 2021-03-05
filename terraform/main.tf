#Define keys and region
provider "aws" {
  region     = var.region
//  access_key = var.access_key
//  secret_key = var.secret_key
}
terraform {
  backend "s3" {
    region = "eu-central-1"
    bucket = "gitlab-ansible-terraform-bucket"
    key    = "tfstates/terraform.tfstate"
  }
}
#Define ec2 instance
resource "aws_instance" "production" {
  count = 1
  ami = var.ami
  instance_type = var.instance_type
  subnet_id = var.subnets[count.index]
  vpc_security_group_ids = [ var.security_group ]
  associate_public_ip_address = true
  key_name = "gitlab-runner"
  tags = {
    Name = "new-production-${count.index}"
  }
}

#Define ec2 instance
resource "aws_instance" "development" {
  count = 1
  ami = var.ami
  instance_type = var.instance_type
  subnet_id = var.subnets[count.index]
  vpc_security_group_ids = [ var.security_group ]
  associate_public_ip_address = true
  key_name = "gitlab-runner"
  tags = {
    Name = "new-development-${count.index}"
  }
}

output "production" {
  value = [for inst in aws_instance.production : inst.public_dns ]
}
output "development" {
  value = [for inst in aws_instance.development : inst.public_dns ]
}
