
#include "childactivity.h"

ChildActivity::ChildActivity():
    ca_id_(-1),a_id_(-1),ca_name_(""),ca_description_(""),ca_socre_(0),
    ca_day_max_join_(1),ca_is_avaiable_(true)
{
}

ChildActivity::ChildActivity(const ChildActivity & rhs)
{
    *this = rhs;
}

ChildActivity::ChildActivity(int ca_id, int a_id, QString ca_name, QString ca_description, double ca_score, int ca_day_max_join):
    ca_id_(ca_id),a_id_(a_id),ca_name_(ca_name),ca_description_(ca_description),ca_day_max_join_(ca_day_max_join),ca_is_avaiable_(true)
{

}

bool ChildActivity::operator ==(const ChildActivity &rhs)
{
    return ca_id_ == rhs.ca_id_;
}

