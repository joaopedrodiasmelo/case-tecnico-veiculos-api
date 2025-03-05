terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
  profile = "terraform"
}

resource "aws_security_group" "security_group" {
  name = "securitygroup"
  description = "Permitir acesso HTTP e acesso a Internet"

  ingress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8090
    to_port     = 8090
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port = 65535
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "ec2_servidor" {
  ami = "ami-05b10e08d247fb927"
  instance_type = "t2.nano"
  user_data = file("user_data.sh")
  vpc_security_group_ids = [aws_security_group.security_group.id]
}



